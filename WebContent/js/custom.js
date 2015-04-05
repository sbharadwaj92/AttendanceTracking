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
	$('#viewtable').dataTable({
        "sDom": 'T<"clear">lfrtip',
            "oTableTools": {
            "sSwfPath": "js/copy_csv_xls_pdf.swf",
                "aButtons": ["copy", "csv", "xls", "pdf", "print"]
        }
    });
});