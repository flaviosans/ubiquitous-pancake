function validate(event){
	var val = event.target.value;
	var format = document.getElementById('format');
	if(rightFormat(val)){
		format.innerHTML = 'Valid Format';
	} else {
		format.innerHTML = 'Invalid Format';
	}
	let info = document.getElementById('info');
	info.innerHTML = res;
}

function rightFormat(value){
	var cnpj = /[0-9]{2}\.[0-9]{3}\.[0-9]{3}\/[0-9]{4}-[0-9]{2}/;
	var cnpjFlat = /[0-9]{14}/;
	return (cnpj.test(value) || cnpjFlat.test(value))
}

