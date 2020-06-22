
function validateForm() {
    return validateFirstName() &&
    validateLastName() &&
    validateEmail() &&
    validateCpf()&& 
    validatePostalCode() &&
    validateCity() &&
    validateAddress() &&
    validatePhone();
}
/*
function validateBirthDate(){
    let birthDate = document.getElementById('birthDateId').value.trim();
    if(validator.isEmpty(birthDate)){
        writeMessageDOM('errorBirthDate','data vazia');
        return false;
    }else if (!validator.isDate(birthDate)) {
        writeMessageDOM('errorBirthDate','data inválida');
        return false;
    }
    removeMessageDOM('errorBirthDate');
   return true;
}*/
function validatePhone(){
    let phone = document.getElementById('phoneId').value.trim();
    if(validator.isEmpty(phone)){
        writeMessageDOM('errorPhone','telefone vazio');
        return false;
    }else if (!jsbrasil.validateBr.celular(phone)){
        //formato aceito (27) 99999-9999
        writeMessageDOM('errorPhone','telefone inválido');
        return false;
    }
    removeMessageDOM('errorPhone');
    return true;
}
function validateAddress(){
    let address = document.getElementById('addressId').value.trim();
    if(validator.isEmpty(address)){
         writeMessageDOM('errorAddress','endereço vazio');
        return false;
    }else if (address.length < 5){
        writeMessageDOM('errorAddress','deve possuir no mínimo 5 caracteres');
        return false;
    }
    removeMessageDOM('errorAddress');
    return true;
}
function validateCity(){
    let city = document.getElementById('cityId').value.trim();
    if(validator.isEmpty(city)){
        writeMessageDOM('errorCity','cidade vazia');
        return false;
    }else if (city.length < 5){
        writeMessageDOM('errorCity','deve possuir no mínimo 5 caracteres');
        return false;
    }
    removeMessageDOM('errorCity');
    return true;
}
function validatePostalCode(){
    let postalCode = document.getElementById('postalCodeId').value.trim();
    if(validator.isEmpty(postalCode)){
        writeMessageDOM('errorCep','CEP vazio');
        return false;
    }else if (!jsbrasil.validateBr.cep(postalCode)){
        writeMessageDOM('errorCep','CEP inválido');
        return false;
    }
    removeMessageDOM('errorCep');
    return true;
}

function validateCpf(){
    let cpf = document.getElementById('cpfId').value.trim();
    if(validator.isEmpty(cpf)) {
        writeMessageDOM('errorCpf','cpf vazio');
        return false;
    }else if  (!jsbrasil.validateBr.cpf(cpf)){
        writeMessageDOM('errorCpf','cpf inválido');
        return false;
    }
    removeMessageDOM('errorCpf');
    return true;
}
function validateEmail(){
    let email = document.getElementById('emailId').value.trim();
    if(validator.isEmpty(email)){
        writeMessageDOM('errorEmail','email vazio');
        return false;
    } else if (!validator.isEmail(email)){
         writeMessageDOM('errorEmail','email inválido');
        return false;
    }
    return true;
}

function validateLastName(){
    let lastName = document.getElementById('lastNameId').value.trim();
    if (validator.isEmpty(lastName)) {
        writeMessageDOM('errorLastName', 'sobrenome vazio');
        return false;
    }else if (lastName.length < 3){
         writeMessageDOM('errorLastName', 'deve conter no mínimo 3 carateres');
        return false;
    }
    removeMessageDOM('errorLastName');
    return true;
}
function validateFirstName() {
    let firstName = document.getElementById('firstNameId').value.trim();
    if (validator.isEmpty(firstName)) {
        writeMessageDOM('errorfirstName', 'nome vazio');
        return false;
    }else if (firstName.length < 3){
         writeMessageDOM('errorfirstName', 'deve conter no mínimo 3 carateres');
        return false;
    }
    removeMessageDOM('errorfirstName');
    return true;
}
function removeMessageDOM(id) {
    let dom = document.getElementById(id);
    dom.style.visibility = '';
    dom.innerHTML = '';
}
function writeMessageDOM(id, msg) {
    let dom = document.getElementById(id);
    dom.style.visibility = 'visible';
    dom.innerHTML = msg;
}

