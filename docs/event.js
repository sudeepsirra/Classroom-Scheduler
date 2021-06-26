    var dt = new Date();
    function renderDate() {
        dt.setDate(1);
        var day = dt.getDay();
        var today = new Date();
        var endDate = new Date(dt.getFullYear(), dt.getMonth() + 1, 0).getDate();
        var prevDate = new Date(dt.getFullYear(), dt.getMonth(), 0).getDate();
        
        var months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
        document.getElementById("month").innerHTML = months[dt.getMonth()];
        document.getElementById("year").innerHTML = dt.getFullYear();
        var cells = "";
        for (x = day; x > 0; x--) {
                cells += "<div class='prev_date'>" + (prevDate - x + 1) + "</div>";
        }
        console.log(day);
        for (i = 1; i <= endDate; i++) {
            if (i == today.getDate() && dt.getMonth() == today.getMonth()) cells += "<div class='today' id='"+i+"' onclick = 'addevents1("+i+")'>" + i + "</div>";
            else
                cells += "<div id='"+i+"' onclick = 'addevents1("+i+")'>" + i + "</div>";
        }
        document.getElementsByClassName("days")[0].innerHTML = cells;
        var lastdayIndex = new Date(dt.getFullYear(), dt.getMonth() + 1, 0).getDay();
        var nextDays = 7- lastdayIndex - 1;
        var monthDays = document.querySelector(".days");
        for(j =1;j<= nextDays; j++)
        {
            cells += `<div class="nexti">${j}</div>`;
            monthDays.innerHTML = cells;
        }
    }

    function moveDate(para) {
        if(para == "prev") {
            dt.setMonth(dt.getMonth() - 1);
        } 
        else if(para == 'next') {
                dt.setMonth(dt.getMonth() + 1);
        }
        renderDate();
    }
    function addevents1(i){
        var x=new Date();
        if(i<10)
        document.getElementById("from").value="2021-06-0"+i+"T"+"15:11";
        else
        document.getElementById("from").value="2021-06-"+i+"T"+"15:11";
        var modal = document.getElementById("mymodal");
        var btn = document.getElementById(i);
        var span = document.getElementsByClassName("close")[0];
        btn.onclick = function() {
            modal.style.display = "block";
        }
        span.onclick = function() {
            modal.style.display = "none";
        }
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    }