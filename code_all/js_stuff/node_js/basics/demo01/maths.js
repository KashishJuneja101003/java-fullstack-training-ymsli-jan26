function add(a, b) {
    return a + b;
}
function diff(a, b) {
    return a - b;
}
function mul(a, b) {
    return a * b;
}
console.log(add(2, 5));

// Option 1
//module.exports = { add, diff, mul };

// Option 2
// module.exports = {
//   add: add,
//   diff: diff,
//   mul: mul
// };
