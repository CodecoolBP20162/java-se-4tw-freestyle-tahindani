$(document).ready(function () {

    var tempValueList = [];
    var tempDateList = [];

    /**
     * This method process the json string which it get from the server. It parse
     * it into javascript object and add the {@code value} and {@code dateString}
     * attribute of the last element to the {@code tempValueList} and {@code tempDateList}
     * respectively.
     * @param resultJson A list of json objects
     */
    function processResultList(resultJson) {
        var temps = JSON.parse(resultJson);
        tempValueList.populate(temps[temps.length - 1].value);
        tempDateList.populate(temps[temps.length - 1].dateString);
        console.log(tempValueList);
    }

    /**
     * This method add a new function to the prototype of the {@code Array}.
     * It add an item to an {@code Array} but only up to ten elements. After
     * ten elements it removes the first element before adding a new.
     * @param item An item to add
     */
    Array.prototype.populate = function (item) {
        if (this.length > 9) {
            this.push(item);
            this.shift();
        } else {
            this.push(item);
        }
    };

    /**
     * This function make an ajax request, get back a list of json-s, process it and pass
     * it to the cart to display. A setInterval is called on it so it repeat in every 5 seconds
     * until it get the result from the server.
     */
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
        , error: function (jqXHR, textStatus, errorThrown) {
            alert("Connection with the server failed");
            clearInterval(intID)
        }});
    }

    main();
    var intID = setInterval(main, 5000);

});
