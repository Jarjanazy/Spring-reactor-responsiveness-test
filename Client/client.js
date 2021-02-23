gradesToBeQuried = [1, 2, 3, 4, 5]

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

function queryGrade(currentIndex){
    let urlWithRandomGradeID = getURLWithRandomGradeID(gradesToBeQuried);
    httpGetAsync(urlWithRandomGradeID, (result) => console.log(currentIndex + result))
}

Array(1000).fill().map((_, i) => queryGrade(i));
console.log("DONE!!!!!")

