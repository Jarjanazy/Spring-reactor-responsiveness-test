gradesToBeQuried = [1, 2, 3, 4, 5]

var t0 = performance.now()

function httpGetAsync(theUrl, callback)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onload = () => callback(xmlHttp.responseText);
    xmlHttp.open("GET", theUrl, true); // true for asynchronous
    xmlHttp.send(null);
}

function getURLWithRandomGradeID(grades){
    randomGradeId = grades[Math.floor(Math.random() * grades.length)];
    return "http://localhost:8080/grade/" + randomGradeId;
}

function checkFinishConditionAndLog(currentIndex, totalNumberOfQueries) {
    if (currentIndex === totalNumberOfQueries - 1) {
        var t1 = performance.now()
        console.log("it took " + (t1 - t0) / 1000 + " seconds.")
    }
}

function queryGrade(currentIndex, totalNumberOfQueries){
    let urlWithRandomGradeID = getURLWithRandomGradeID(gradesToBeQuried);
    httpGetAsync(urlWithRandomGradeID, (result) => {
        console.log(currentIndex + result);
        checkFinishConditionAndLog(currentIndex, totalNumberOfQueries);
    })
}

function runQueries(){
    const totalNumberOfQueries = 1000;
    Array(totalNumberOfQueries).fill().map((_, i) => queryGrade(i, totalNumberOfQueries));
}

runQueries();

