$(document).ready(function () {

    $("#add").click(function () {
        $(".add").toggle();
        $(".read").hide();
        $(".update").hide();
        $(".delete").hide();
    });
    $("#read").click(function () {
        $(".read").toggle();
        $(".add").hide();
        $(".update").hide();
        $(".delete").hide();
    });
    $("#update").click(function () {
        $(".update").toggle();
        $(".add").hide();
        $(".read").hide();
        $(".delete").hide();
    });
    $("#delete").click(function () {
        $(".delete").toggle();
        $(".add").hide();
        $(".update").hide();
        $(".read").hide();
    });

});