$(document).ready(function () {
    $('#file').change(function () {
        alert("/images/"+this.files[0].name)
        $('#sh-image').attr('src',"/images/"+this.files[0].name)
    })

})