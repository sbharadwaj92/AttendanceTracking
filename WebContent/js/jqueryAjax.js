$(function() {
	$(".info_link").click(function()
	{
		var el = $(this);
		el.attr('data-content','');
		var empId =
		{
			"empId" : $(this).attr('href')
		};
		$.ajax
		({
			url : "viewDetailss",
			data : JSON.stringify(empId),
			dataType : 'json',
			contentType : 'application/json',
			type : 'POST',
			async : true,
			success : function(day)
			{
				console.log(day.dates.length);
				var content = "<table><tbody>";
				for (var i = 0; i < day.dates.length; i++)
				{
					content= content+'<tr><td>'+ day.dates[i].toUpperCase()+'</td></tr>';
				}
				var content = content + '</tbody></table>';
				el.attr('data-content',content);
				console.log(content);
				el.popover('show');
			}
		});
	});
});