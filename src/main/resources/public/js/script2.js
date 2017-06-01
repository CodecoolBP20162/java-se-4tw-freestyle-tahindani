$ (document).ready(function () {

    var tempList = [];
    var tempValueList = [];
    var tempDateList = [];


    function processResult(resultJson) {
        var temp = JSON.parse(resultJson);
        tempValueList.push(temp.value);
        tempDateList.push(temp.dateString);
    }

    function processResultList(resultJson){
        var temps = JSON.parse(resultJson);
        tempValueList.push(temps[temps.length-1].value);
        tempDateList.push(temps[temps.length-1].dateString);
        console.log(tempValueList);

    }

    $('#getTemp').click(function(){
        $.ajax({url: "/getTemps", success: function(result){
            // processResult(result);
            // console.log(tempValueList);
            // console.log(tempDateList);
            processResultList(result);



        }});


    var myChart = Highcharts.chart('cartContainer', {
        chart: {
            type: 'line'
        },
        title: {
            text: 'Monthly Average Temperature'
        },
        subtitle: {
            text: 'Source: WorldClimate.com'
        },
        xAxis: {
            categories: tempDateList //[tempList[tempList.length-10].dateString,tempList[tempList.length-9].dateString,tempList[tempList.length-8].dateString,tempList[tempList.length-7].dateString,tempList[tempList.length-6].dateString,tempList[tempList.length-5].dateString,tempList[tempList.length-4].dateString,tempList[tempList.length-3].dateString,tempList[tempList.length-2].dateString,tempList[tempList.length-1].dateString ]
        },
        yAxis: {
            title: {
                text: 'Temperature (°C)'
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        series: [{
            name: 'RandomCity',
            data: tempValueList //[tempList[tempList.length-10].value,tempList[tempList.length-9].value,tempList[tempList.length-8].value,tempList[tempList.length-7].value,tempList[tempList.length-6].value,tempList[tempList.length-5].value,tempList[tempList.length-4].value,tempList[tempList.length-3].value,tempList[tempList.length-2].value,tempList[tempList.length-1].value ]
        }]
    });
    });

});
