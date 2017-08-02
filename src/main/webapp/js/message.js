/**
 * Created by Дімон on 31.07.2017.
 */
// var eeeeeeee = $('#setSecuredUser').context;
//     console.log(eeeeeeee);






$('#sendMessage').click(function () {
//        console.log(window.location.pathname);

    var idUserReciever = 0;
    var id2 = $('#id2').val();
    var id1 = $('#id1').val();
    var idActiveUser = $('#idActiveUser').val();
    if (idActiveUser == id1) {
        idUserReciever = id2;
    } else {
        idUserReciever = id1;
    }


    var message = {
        message: $('#messageContent').val(),
        userReceiver: {
            id: idUserReciever
        }
    };
    if ($('#messageContent').val() != '') {

        $('#messageContent').val('');

        $.ajax({
            url: '/sendMessage?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(message),
            success: function (res) {
                var idSender = idActiveUser;
                var divSender = '';

                for (var i in res) {
                    if (idSender == res[i].userSender) {
                        divSender += '<div class="chat-message chat-message-sender">' +
                            '<img class="chat-image chat-image-default" src="http://ashwinsaxena.com/favicon.png"/>' +
                            '<div class="chat-message-wrapper">' +
                            '<div class="chat-message-content">' +
                            '<p>' + res[i].message + '</p>' +
                            '</div></div></div>';
                    } else {
                        divSender += '<div class="chat-message chat-message-recipient">' +
                            '<img class="chat-image chat-image-default" src="http://ashwinsaxena.com/favicon.png"/>' +
                            '<div class="chat-message-wrapper">' +
                            '<div class="chat-message-content">' +
                            '<p>' + res[i].message + '</p>' +
                            '</div></div></div>';

                    }
                }
                $('.result').html(divSender);
            },
            error: function (err) {
                console.log(err);
            }
        })
    } else {

    }
});


loadDialogue();

function loadDialogue() {
//        console.log(window.location.pathname);
    $.ajax({
        url: '/preloadDialogues/' + $('#id1').val() + "/" + $('#id2').val(),
        method: 'GET',
        success: function (res) {
            var idSender = $('#idActiveUser').val();
            var divSender = '';
            for (var i in res) {
                if (idSender == res[i].userSender) {
                    divSender += '<div class="chat-message chat-message-sender">' +
                        '<img class="chat-image chat-image-default" src="http://ashwinsaxena.com/favicon.png"/>' +
                        '<div class="chat-message-wrapper">' +
                        '<div class="chat-message-content">' +
                        '<p>' + res[i].message + '</p>' +
                        '</div></div></div>';
                } else {
                    divSender += '<div class="chat-message chat-message-recipient">' +
                        '<img class="chat-image chat-image-default" src="http://ashwinsaxena.com/favicon.png"/>' +
                        '<div class="chat-message-wrapper">' +
                        '<div class="chat-message-content">' +
                        '<p>' + res[i].message + '</p>' +
                        '</div></div></div>';

                }
            }
            $('.result').html(divSender);
        },
        error: function (err) {
            console.log(err);
        }
    })

}