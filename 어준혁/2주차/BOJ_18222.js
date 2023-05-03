const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input;
rl.on("line", (line) => {
  input = line.trim();
  rl.close();
});

rl.on("close", () => {
  console.log(solution(input).toString());
});

function solution(k) {
  k = BigInt(k);
  if (k === 1n) return 0n;
  let max = 1n;
  while (max * 2n < k) max *= 2n;
  let prev = solution(k - max);
  return 1n - prev;
}