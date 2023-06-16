function getRadix(number, radix) {
	const digits = getDigitTable();

	if(radix < 2 || radix >= digits.length || number <= 0) {
		throw new Error("Invalid args");
	}

	let valueStr = '';

	while(number > 0) {
		valueStr = digits[number % radix] + valueStr;
		number = Math.floor(number / radix);
	}

	return valueStr;
}

function getDigitTable() {
	const digits = [];

	for (let i = '0'.charCodeAt(0); i <= '9'.charCodeAt(0); i++) {
		digits.push(String.fromCharCode(i));
	}

	for (let i = 'A'.charCodeAt(0); i <= 'Z'.charCodeAt(0); i++) {
		digits.push(String.fromCharCode(i));
	}
	return digits;
}

