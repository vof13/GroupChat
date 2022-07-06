$(function(){

   $.get('/init', {}, function (response) {
      if (!response.result) {
         let name = prompt('Введите ваше имя:');
         registerUser(name);
         return;
      }
      initApplication();
   })

   let registerUser = function (name) {
      $.post('/auth', {name: name}, function (response) {
         if (response.result) {
            initApplication();
         }
      })
   };

   function updateUsers() {
      $.get('/user', {}, function (response) {
         if (response.length == 0) {
            return;
         }
         $('.users-list').html('');
         for (i in response) {
            $('.users-list').append($('<div>' + response[i] + '</div>'));
         }
      })
   }

   let initApplication = function (){
      $('.messages-and-users').css({display: 'flex'});
      $('.controls').css({display: 'flex'});
      $('.send-message').on('click', function (){
         let message = $('.new-message').val();
         $.post('/message', {message: message}, function (responce){
            if (responce.result) {
               $('.new-message').val('');
            } else {
               alert('Ошибка ввода');
            }
         })
      });
      setInterval(updateMessages, 1000);
      setInterval(updateUsers, 1000);
   };


   let updateMessages = function (){
      $('.messages-list').html('<i>Сообщений нет</i>');
      $.get('/message', {}, function (response){
         if (response.length == 0) {
            return;
         }
         $('.messages-list').html('');
         for (i in response) {
            let element = getMessageElement(response[i]);
            $('.messages-list').append(element);
         }
      });
   };

   let getMessageElement = function (message) {
      let header = $('<div class="message-header"></div>');
      header.append($('<div class="username">' + message.username +  '</div>'));
      header.append($('<div class="datetime">' + message.datetime +  '</div>'));
      let textElement = $('<div class="message-text"></div>')
      textElement.text(message.text);
      let item = $('<div class ="message-item"></div>');
      item.append(header, textElement);
      return item;
   };
});