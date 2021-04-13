//alert("Лабараторная 1")        //Высвечивающийся текст
GET /index.html
let result
let input1=0
let input2=0
let input3=0
let inputIn1 = document.querySelector('.input1')
inputIn1.value=''
let inputIn2 = document.querySelector('.input2')
inputIn2.value=''
let inputIn3 = document.querySelector('.input3')
inputIn3.value=''
let div = document.querySelector('.out')
let button4 = document.querySelector('.button4')
/*let inputIn1 = document.querySelector('.input1')
inputIn1.value=''
let button1 = document.querySelector('.button1')

let inputIn2 = document.querySelector('.input2')
inputIn2.value=''
let button2 = document.querySelector('.button2')

let inputIn3 = document.querySelector('.input3')
inputIn3.value=''
let button3 = document.querySelector('.button3')

let div = document.querySelector('.out')
let button4 = document.querySelector('.button4')

button1.onclick=function(){
    input1=+inputIn1.value
    console.log(input1)
    //inputIn1.value=''
}
button2.onclick=function(){
    input2=+inputIn2.value
    console.log(input2)
    //inputIn2.value=''
}
button3.onclick=function(){
    input3=+inputIn3.value
    console.log(input3)
    //inputIn3.value=''
}*/
button4.onclick=function(){
    input1=+inputIn1.value
    input2=+inputIn2.value
    input3=+inputIn3.value
    if (input1>input2) result=input1 
    else result=input2
    if (input3>result) result=input3
    div.innerHTML="Максимальное число "+result
    console.log("Максимальное число "+result)    
}

