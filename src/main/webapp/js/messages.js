/**
 * Created by Дімон on 05.07.2017.
 */

function saveFriendId(frendId) {

    var teg = '<input id="friendId" type="hidden"  value="' +
        frendId +
        '"/>'
        document.getElementById('friendIdDiv').innerHTML =teg;
}


$('#sendMessage').click(function () {

    var message = {
        message : $('#messageContent').val(),
        userReceiver : {
            id : $('#friendId').val()
        }

    };

    $('#messageContent').val('');

    $.ajax({
        url: '/sendMessage?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(message),
        success: function (res) {

        },
        error: function (err) {
            console.log(err)
        }
    })
    $('#closeModalWindow').click()

});



// $('#saveMessage').click(function () {
//
//     var message = {
//         name: $('#cityName').val()
//     };
//
//     $('#cityName').val('');
//
//     $.ajax({
//         url: '/city?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
//         method: 'POST',
//         dataType: 'json',
//         contentType: 'application/json; charset=UTF-8',
//         data: JSON.stringify(city),
//         success: function (res) {
//             parseResultFromDb(res);
//         },
//         error: function (err) {
//             console.log(err)
//         }
//     })
// });

// loadFriends();
//
// function deleteCity(idCity) {
//
//     $.ajax({
//
//         url: '/city?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
//         method: 'DELETE',
//         data: JSON.stringify(idCity),
//         success: function (res) {
//             parseResultFromDb(res);
//         },
//         error: function (err) {
//             console.log(err)
//         }
//     })
//
// }
//
// function loadFriends() {
//     $.ajax({
//
//         url: '/loadFriends?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
//         method: 'GET',
//         success: function (res) {
//             parseResultFromDb(res);
//         },
//         error: function (err) {
//             console.log(err)
//         }
//     })
//
// };
//
//
// function updateCity(idCity) {
//
//     $.ajax({
//
//         url: '/city?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
//         method: 'GET',
//         success: function (res) {
//             var citiesFromDb = '';
//             for (var i in res) {
//
//                 if(res[i].id == idCity){
//                     citiesFromDb += '<tr><td><input type="text" class="form-control" value="'+res[i].name+'" id="newCityName"></td><td><button class="btn btn-default save" onclick="saveCityUpdates(' + res[i].id + ')">save updates</button></td></tr>';
//                 }else{
//                     citiesFromDb += '<tr><td id=' + res[i].id + "city" + '>' + res[i].name + '</td><td></td></tr>';
//                 }
//
//             }
//             document.getElementById('result').innerHTML = citiesFromDb;
//         },
//         error: function (err) {
//             console.log(err)
//         }
//     })
// }
//
// function saveCityUpdates(idCity) {
//
//     var newName = $('#newCityName').val();
//
//     $.ajax({
//
//         url: '/city?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
//         method: 'PUT',
//         data: newName+'_'+idCity,
//         success: function (res) {
//
//             parseResultFromDb(res);
//
//         },
//         error: function (err) {
//             console.log(err)
//         }
//     })
//
// }
//
function parseResultFromDb(res) {
    var citiesFromDb = '';

    for (var i in res) {
        citiesFromDb += '<tr><td>' + res[i].firstName +'</td></tr>';
    }

    document.getElementById('result').innerHTML = citiesFromDb;

}
