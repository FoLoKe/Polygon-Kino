$(document).ready(function() {
    setDefault();

    $("#locales").change(function () {
        var selectedOption = $('#locales').val();
        if (selectedOption != ''){
            window.location.replace('changeLang?lang=' + selectedOption);
        }
    });
});

function setDefault() {
    var locale = Cookies.get('locale');

    if (locale == null) {
        locale = 'en';
        Cookies.set('locale', locale);
    }

    $("#locales").val(locale);
}