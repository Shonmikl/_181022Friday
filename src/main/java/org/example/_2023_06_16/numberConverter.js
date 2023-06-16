function convertNumber(number, currentRadix, targetRadix) {
    const decimalValue = parseInt(number, currentRadix);
    return decimalValue.toString(targetRadix);
}