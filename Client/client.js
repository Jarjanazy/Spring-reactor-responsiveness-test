
function httpGetAsync(theUrl, callback)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = () => callback(xmlHttp.responseText);
    xmlHttp.open("GET", theUrl, true); // true for asynchronous
    xmlHttp.send(null);
}


httpGetAsync("http://localhost:8080/grade/1", (result) => console.log(result))