//import * as request from "request-promise-native";

const urlParams = new URLSearchParams(window.location.search);
var workspace: string = urlParams.get('workspace'); 
var pName: string = urlParams.get('pName');
const redirectURI: string = window.location.origin + "/" + urlParams.get('hash');
var sCode: number = 0;

function isAvailable() {
    var xmlHttp: XMLHttpRequest = new XMLHttpRequest();
    xmlHttp.open( "GET", redirectURI, false ); // false for synchronous request
    xmlHttp.send( null );
    sCode =  xmlHttp.status;
    redirect();
}

function redirect() {
    if (sCode === 200) {
        //console.log("REDIRECT");
        window.location.href = redirectURI;
    } else {
        setTimeout(() => isAvailable(), 2000);
    }
}

isAvailable();