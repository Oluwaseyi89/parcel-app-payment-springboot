let orderId = document.getElementById('orderId');
let customerId = document.getElementById('customerId');
let customerName = document.getElementById('customerName');
let amount = document.getElementById('amount');
let provider = document.getElementById('provider');
let paymentType = document.getElementById('paymentType');
let statuus = document.getElementById('status');
let isCustomer = document.getElementById('isCustomer');
let createdAt = document.getElementById('createdAt');
let updatedAt = document.getElementById('updatedAt');
let subBtn = document.getElementById('subBtn');

subBtn.addEventListener('click', (e) => {
    e.preventDefault();
    let messBody = {
        "orderId": orderId.value,
        "customerId": customerId.value,
        "customerName": customerName.value,
        "amount": amount.value,
        "provider": provider.value,
        "paymentType": paymentType.value,
        "status": statuus.value,
        "isCustomer": isCustomer.checked,
        "createdAt": createdAt.value,
        "updatedAt": updatedAt.value
    }

    console.log(JSON.stringify(messBody));

    fetch('http://localhost:8080/make_payment', {
        method: "POST",
        mode: "same-origin",        
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(messBody)
    }).then((res)=>console.log(res.statusText))
    .catch((err)=>console.log(err));
});