$(document).ready(function () {

    var tempValueList = [];
    var tempDateList = [];

    function processResultList(resultJson) {
        var temps = JSON.parse(resultJson);
        tempValueList.push(temps[temps.length - 1].value);
        tempDateList.push(temps[temps.length - 1].dateString);
        console.log(tempValueList);
    }

    $('#getTemp').click(function () {
        $.ajax({
            url: "/getTemps", success: function (result) {
                processResultList(result);

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
                        categories: tempDateList
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
                        data: tempValueList
                    }]

                });
            }
        });
    });

});
