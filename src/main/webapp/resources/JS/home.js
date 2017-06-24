/**
 * Created by Yerchik on 24.05.2017.
 */

function addShow() {
    cleanErrorMessages()
    clearAdd();
    $("#add").slideToggle(300);
}

function clearAdd() {
    document.getElementById('author').value = '';
    document.getElementById('name').value = '';
}

function addBook() {
    if (validateAdd()) {
        $.ajax({
            url: '/add/',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(getBook()),
            success: function () {
                cleanErrorMessages();
                alert('Added!')
                $("#add").hide();
                $("#list").hide();
                $("#edit").hide();
            }
        });
    }
}
function validateAdd() {
    var object = getBook();
    if (object.author != '' && object.name != '' ) {
        return true;
    }
    else {
        showErrorMessage();
        return false;
    }
}

function getBook() {
    return {
        author: $("#author").val(), name: $("#name").val()
    };
}

function showErrorMessage() {

    var html = "<div >"
        + "<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button>"
        + "<strong>Oh snap!</strong> fill all lines"
        + "</div>"
    $("#errorMessage").append(html);
}

function cleanErrorMessages() {
    $("#errorMessage").empty();
}


function listShow() {
    $("#allbooks").empty();
    $.ajax({
        url: '/getAllBooks',
        method: 'GET',
        contentType: 'application/json',
        success: function (response) {
            for (var i = 0; i < response.length; i++) {
                $("#allbooks").append((i + 1) + ". \"" + response[i].author + " " + response[i].name + "\" <br>")
            }
            $("#list").slideToggle();
        }
    })
}

function removeBook(){
    clearBook();
    var s = document.querySelector("#book").options;
    $.ajax({
        url: '/getAllBooks',
        method: 'GET',
        contentType: 'application/json',
        success: function (response) {
            for (var i = 0; i < response.length; i++) {
                s[i + 1] = new Option(response[i].author + " \"" + response[i].name + "\"", response[i].author + "," + response[i].name, true);
            }
            $("#remove").slideToggle(300);
        }
    })


}
function clearBook() {
    var s = document.querySelector("#book").options;
    var s1 = document.querySelector("#editbook").options;
    for (var i = 1; i <= s.length; i++) {
        s[i] = null;
    }
    for (var i = 1; i <= s1.length; i++) {
        s1[i] = null;
    }
}

function removeBook2() {
    if(document.getElementById('book').value != '') {
        $.ajax({
            url: '/remove/' + document.getElementById('book').value,
            method: 'POST',
            contentType: 'application/json',
            success: function () {
                alert('Book removed')
                $("#remove").hide();
                $("#list").hide();
                $("#edit").hide();

            }
        })
    }
}
function editBook(){
    clearBook();
    var s = document.querySelector("#editbook").options;
    $.ajax({
        url: '/getAllBooks',
        method: 'GET',
        contentType: 'application/json',
        success: function (response) {
            for (var i = 0; i < response.length; i++) {
                s[i + 1] = new Option(response[i].author + " \"" + response[i].name + "\"", response[i].author + "," + response[i].name, true);
            }
            $("#edit").slideToggle(300);
        }
    })
}

function editBook2() {
    if(document.getElementById('editbook').value != '' && document.getElementById('newName').value != '') {
        $.ajax({
            url: '/edit/' + document.getElementById('editbook').value + ',' + document.getElementById('newName').value,
            method: 'POST',
            contentType: 'application/json',
            success: function () {
                alert('Book edited')
                $("#remove").hide();
                $("#list").hide();
                $("#edit").hide();
            }
        })
    }
}