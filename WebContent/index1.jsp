<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ADBMS Project</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
<body>
	
	
<div class="container">
	<h1>Zomato App Usage By Country on the Basis of Votes Analysis (DoughNut View)</h1>
			<a href="/adbm/Home.jsp" style="float:right;">Home</a>
			<br><br>
			<canvas id="myChart1"></canvas>
			<div id="div1">
			</div>
		</div>
<script>
var ajaxArray;
$(document).ready(function(){
    
        $.ajax({url: "/adbm/testproject?q=2", success: function(result){
        	var con = JSON.parse(result);
        	var p = con[0]
        	var lab=[];
        	var dat=[];
        	for(x in p)
        	{
        		lab.push(x);
        		dat.push(p[x]);
        		console.log(x+ " "+ p[x]);
        	}
        	console.log(lab);
        	console.log(dat);
        	var x="";
        	for(var i=0;i<lab.length;i++)
        	{
        		x += lab[i]+" : "+dat[i]+"<br>"
        	}
        	$('#div1').html(x);

        	//var myChart = document.getElementById('myChart').getContext('2d');
        	var myChart1 = document.getElementById('myChart1').getContext('2d');
        	var doughnut = new Chart(myChart1, {
        		
        		type:'doughnut',
        		data:{
        			labels:lab,
        			datasets:[{
        				label:'App Usage',
        				data:dat,
        				backgroundColor: [
        				                  "#f38b4a",
        				                  "#56d798",
        				                  "#ff8397",
        				                  "#6970d5",
        				                  "#4051BD",
        				                  "#BDAF40",
        				                  "#9C5F98",
        				                  "#C25716",
        				                  "#EC2D1D",
        				                  "#16E637",
        				                  "#16E6CB",
        				                  "#9BA612",
        				                  "#12A68C",
        				                  "#99B3D1"
        				                ]
        			}]
        		},
        		options:{
        			
        			scales: {
        				yAxes: [{
        					ticks: {
        						beginAtZero:true
        					}
        				}]
        			}
        		
        		}
        	});
        	
        	/*var massPopChart = new Chart(myChart, {
        		
        		type:'bar',
        		data:{
        			labels:lab,
        			datasets:[{
        				label:'App Usage',
        				data:dat,
        				backgroundColor: [
        				                  "#f38b4a",
        				                  "#56d798",
        				                  "#ff8397",
        				                  "#6970d5",
        				                  "#4051BD",
        				                  "#BDAF40",
        				                  "#9C5F98",
        				                  "#C25716",
        				                  "#EC2D1D",
        				                  "#16E637",
        				                  "#16E6CB",
        				                  "#9BA612",
        				                  "#12A68C",
        				                  "#99B3D1"
        				                ]
        			}]
        		},
        		options:{
        			
        			scales: {
        				yAxes: [{
        					ticks: {
        						beginAtZero:true
        					}
        				}]
        			}
        		
        		}
        	});*/

        }});
      
});	

</script>		
</body>
</html>