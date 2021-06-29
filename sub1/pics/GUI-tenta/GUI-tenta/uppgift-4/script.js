//anonymiseringskod: DVGA11-0027-DGX

'use strict';

let bookingList = document.querySelector("#bookingList");
let tableList = [];
let buttonList = [];
let isBooked = false;
let table = 0;
for(let i = 0; i < 16; i++) {
    let li = document.createElement('li');
    li.setAttribute('class', 'list-unstyled');
    li.textContent = "Bord " + (i + 1);

    let button = document.createElement('button');
    button.setAttribute('class', 'btn btn-success');
    button.textContent = "Boka";

    buttonList.push(button);
    tableList.push(li.textContent);

    button.addEventListener("click", () => {
        if(isBooked === false){
            book(li.textContent);
        } else {
            unbook(li.textContent);
        }
    });

    let div = document.createElement('div');

    let leftDiv = document.createElement('div');
    leftDiv.setAttribute('class', 'col-6');

    let rightDiv = document.createElement('div');
    rightDiv.setAttribute('class', 'col-6');

    div.setAttribute('class', 'row');

    let br = document.createElement('br');

    leftDiv.appendChild(li);
    rightDiv.appendChild(button);
    div.appendChild(leftDiv);
    div.appendChild(rightDiv);
    bookingList.appendChild(div);


}

console.log(tableList);

function book(value) {
    let bookings = bookingList.childNodes;
    for(let i = 0; i < tableList.length; i++) {
        if(value === tableList[i]) {
            buttonList[i].removeAttribute('class');
            buttonList[i].setAttribute('class', 'btn btn-danger col');
            buttonList[i].textContent = "Bokat";
            table = i + 1;
            isBooked = true;
            alert("Du har bokat bord " + (i + 1));
        }

    }
}

function unbook(value) {
    let bookings = bookingList.childNodes;
    for(let i = 0; i < tableList.length; i++) {
        if(value === tableList[i] && ((i + 1) === table)) {
            buttonList[i].removeAttribute('class');
            buttonList[i].setAttribute('class', 'btn btn-success col');
            buttonList[i].textContent = "Boka";
            isBooked = false;
            alert("Du har avbokat bord " + (i + 1));
        }

    }
}