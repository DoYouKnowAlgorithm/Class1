const fs = require("fs");

const input = fs.readFileSync("/dev/stdin").toString().split("\n");
const N = parseInt(input[0]);
const graph = [];
for (let i = 1; i <= N; i++) {
  graph.push(input[i].split(" ").map(Number));
}

console.log(Split(0, 0, N, graph));

function Split(x, y, n, graph) {
    if (n === 1) {
      return graph[x][y];
    } else {
      const list = [
        Split(x, y, n / 2, graph),
        Split(x, y + (n / 2), n / 2, graph),
        Split(x + (n / 2), y, n / 2, graph),
        Split(x + (n / 2), y + (n / 2), n / 2, graph)
      ];
      list.sort((a, b) => a - b);
      return list[1];
    }
  }
  