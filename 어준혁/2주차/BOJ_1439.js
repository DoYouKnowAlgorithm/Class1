const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim()

const result = []

for(let i=0; i < input.length; i++){
    if(i === 0 || input[i] !== input[i-1]) result.push(input[i])
}
const ones = result.filter(x => x === '1').length;
const zeros = result.filter(x => x === '0').length;

console.log(Math.min(ones, zeros));
