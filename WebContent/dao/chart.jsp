<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Mono&display=swap"
	rel="stylesheet">
<style>
body {
	font-family: 'Roboto Mono', monospace;
	font-size: 24px;
}
</style>


<!--Load the AJAX API-->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	
	
	// Load the Visualization API and the corechart package
	google.charts.load('current', {
		'packages' : [ 'corechart' ],
		'language' : 'cn'
	});

	// Set a callback to run when the Google Visualization API is loaded.
	google.charts.setOnLoadCallback(drawChart);
	google.charts.setOnLoadCallback(drawChart2);
	// Callback that creates and populates a data table,
	// instantiates the pie chart, passes in the data and
	// draws it.
	function drawChart() {

		// Create the data table.
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'name');
		data.addColumn('number', 'int');
		
		
		data.addRows([ [ '飲食', parseInt($("#foodCost").val()) ], [ '交通', parseInt($("#trspCost").val()) ], 
		               [ '日常生活', parseInt($("#utilCost").val()) ], [ '娛樂', parseInt($("#enterCost").val()) ], 
		               [ '醫療', parseInt($("#medCost").val()) ], [ '其他' , parseInt($("#otherCost").val())] ]);

       
		// Set chart options
		var options = {
			'title' :
				'看你花的多兇噴噴',
			'width' : 800,
			'height' : 600
		};

		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.PieChart(document
				.getElementById('chart_pie'));
		chart.draw(data, options);
	}
	
	
	function drawChart2() {

		// Create the data table.
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'name');
		data.addColumn('number', 'int');
		data.addRows([ [ '飲食', parseInt($("#foodCost").val()) ], [ '交通', parseInt($("#trspCost").val()) ], 
            [ '日常生活', parseInt($("#utilCost").val()) ], [ '娛樂', parseInt($("#enterCost").val()) ], 
            [ '醫療', parseInt($("#medCost").val()) ], [ '其他' , parseInt($("#otherCost").val())]  ]);

		// Set chart options
		var options = {
			'width' : 800,
			'height' : 600
		};

		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.LineChart(document
				.getElementById('chart_line'));
		chart.draw(data, options);
	}
</script>
</head>


<body bgcolor="#c89f84">
    <p style="font-size:16px;">消費圖表</p>
	
	<input type=hidden id="foodCost" value="${pt.foodCost}" />
	<input type=hidden id="trspCost" value="${pt.trspCost}" />
	<input type=hidden id="utilCost" value="${pt.utilCost}" />
	<input type=hidden id="enterCost" value="${pt.enterCost}" />
	<input type=hidden id="medCost" value="${pt.medCost}" />
	<input type=hidden id="otherCost" value="${pt.otherCost}" />
	
 	
 	
 	
	<!--Div that will hold the pie chart-->
	<div id="chart_pie"></div>
	<div id="chart_line"></div>
	<p>
		<font size=5><b><a href="../../main.jsp">回主功能頁</a></b></font>
	</p>
	
	
	
</body>
</html>