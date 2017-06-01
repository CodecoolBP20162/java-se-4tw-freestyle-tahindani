$(document).ready(function () {

    var tempValueList = [];
    var tempDateList = [];

    function processResultList(resultJson) {
        var temps = JSON.parse(resultJson);
        tempValueList.populate(temps[temps.length - 1].value);
        tempDateList.populate(temps[temps.length - 1].dateString);
        console.log(tempValueList);
    }

    // this method maximize the length of the array
    Array.prototype.populate = function (item) {
        if (this.length > 9) {
            this.push(item);
            this.shift();
        } else {
            this.push(item);
        }
    };

    function main() {
        $.ajax({url: "/getTemps", success: function (result) {
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
    }

    main();
    setInterval(main, 5000);

});
