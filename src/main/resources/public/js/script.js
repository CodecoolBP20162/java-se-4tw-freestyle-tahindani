$( document ).ready(function() {
    // setTimeout(function(){
    //     window.location.reload(true);
    // }, 3000);

    // For todays date;
    Date.prototype.today = function () {
        return (this.getFullYear() +"/"+ (this.getMonth()+1) +"/"+ this.getDate());
    };

    // For the time now
    Date.prototype.timeNow = function () {
        return ((this.getHours() < 10)?"0":"") + this.getHours() +":"+ ((this.getMinutes() < 10)?"0":"") + this.getMinutes() +":"+ ((this.getSeconds() < 10)?"0":"") + this.getSeconds();
    };

    var newDate = new Date();
    var datetime = newDate.today() + " @ " + newDate.timeNow();
    console.log(datetime);

    var ctx = $("#myChart");
    var chart = new Chart(ctx, {
        // The type of chart we want to create
        type: 'line',


        // The data for our dataset
        data: {
            labels: [datetime, "February", "March", "April", "May", "June", "July"],
            datasets: [{
                label: "My First dataset",
                // backgroundColor: 'rgb(255, 99, 132)',
                borderColor: 'rgb(255, 99, 132)',
                data: [0, 10, 5, 2, 20, 30, 45],
            }]
        },

        // Configuration options go here
        options: {}

    });


});

