$(document).ready(function () {
	 $("#form").submit(function () {
	    $(".submitBtn").attr("disabled", true);
	    return true;
	 });
	$('.form-group input').datepicker({
	    format: "dd-mm-yyyy",
	    orientation: "top left",
	    autoclose: true,
	    endDate: "-1d"
	});
});