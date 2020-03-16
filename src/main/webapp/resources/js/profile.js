function getAuthUserProfileData () {
    $.getJSON('rest/profile', function(data) {
        $('#balance').html(data.balance);
    });
}

function registerUser() {
    $.ajax({
        type: "POST",
        url: "rest/profile/register",
        data: JSON.stringify($('#profile_form').serializeObject()),
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            window.location.href = "login?message=app.registered&username=" + data.login;
        },
        error: function (jqXHR) {
            failNoty(jqXHR);
        }
    });
}