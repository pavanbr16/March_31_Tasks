let num = parseInt(prompt('enter number n'));

let run = (num) => {
  for (let i = 0; ; i++) {
    if (2 ** i === num) return num;
    if (2 ** i > num) return 2 ** i;
  }
};

console.log(run(num));
