function main() {
    const weights = [3,4,5,8,9];
    const prices =  [1,6,4,7,6];
    const maxWeight = 13;

    const count = weights.length;
    const A = Array.from({length: count + 1}, ()=> Array(maxWeight + 1).fill(0));

    for(let k = 1; k <=count; k++) {
        for(let s = 1; s <= maxWeight; s++) {
            if(weights[k-1] <= s) {
                A[k][s] = Math.max(A[k-1][s], A[k-1][s - weights[k-1]] + prices[k-1]);
            } else {
                A[k][s] = A[k-1][s];
            }
        }
    }

    const result = [];
    trace(A, weights, count, maxWeight, result);

    console.log("Opt: ");
    for(const item of result) {
        console.log(item);
    }
}


function trace(A, weights, k, s, result) {
    if(k === 0 || s === 0) {
        return;
    }

    if(A[k][s] === A[k-1][s]) {
        trace(A, weights, k - 1, s, result);
    } else {
        trace(A, weights, k - 1, s - weights[k-1], result);
        result.push(k);
    }
}