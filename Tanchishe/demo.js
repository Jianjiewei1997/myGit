//点击开始游戏，startPage消失，游戏开始
//随机出现食物，出现三节蛇开始运动
//上下左右运动，改变运动方向
//判断吃到食物，食物消失，蛇加一节
//判断游戏结束，弹出结束框

var startBtn = document.getElementById("startBtn");
var startP = document.getElementById("startP");
var close = document.getElementById("close");
var loserScore = document.getElementById("loserScore");
var lose = document.getElementById("lose");
var scoreBox = document.getElementById("score");
var move = document.getElementById("move");
var startPage = document.getElementById("startPage");
var snakeMove;
var speed = 70;

var startGameBoolean = true; //是否可以开始游戏
var startPaushBoolean = true; //true位可以开始游戏，false为暂停游戏，最开始是没有暂停游戏

function init() {
    //地图属性(宽度、高度)
    this.mapW = parseInt(getComputedStyle(move).width); //width是百分比，getComputedStyle取出来的是字符串
    this.mapH = parseInt(getComputedStyle(move).height);
    this.mapDiv = move;

    //食物
    this.foodH = 20;
    this.foodW = 20;
    this.foodX = 0;
    this.foodY = 0;

    //蛇
    this.snakeH = 20;
    this.snakeW = 20;
    this.snakeBoby = [[3,1,'head'],[2,1,'body'],[1,1,'body']];

    //游戏属性
    this.direct = 'right';
    this.score = 0;

    bindEvent();
}

function startGame() {
    startPage.style.display = "none";
    startP.style.display = "block";
    food();
    snake();
    bindEvent();
}

function food() {
    var food = document.createElement("div");
    food.style.width = this.foodW + "px";
    food.style.height = this.foodH + "px";
    this.foodX = Math.floor(Math.random() * (this.mapW/20)); //random随机生成0到1的数，floor取整
    this.foodY = Math.floor(Math.random() * (this.mapH/20));
    food.style.left = this.foodX * 20 + "px";
    food.style.top = this.foodY * 20 + "px";
    this.mapDiv.appendChild(food).setAttribute("class","food");
}

function snake() {
    for(var i = 0;i < this.snakeBoby.length;i++){
        var snake = document.createElement("div");
        snake.style.width = this.snakeW + "px";
        snake.style.height = this.snakeH + "px";
        snake.style.left = this.snakeBoby[i][0] * 20 +"px";
        snake.style.top = this.snakeBoby[i][1] * 20 + "px";
        snake.classList.add(this.snakeBoby[i][2]);
        this.mapDiv.appendChild(snake).classList.add("snake");
    }
}

function action() {
    for(var i = this.snakeBoby.length-1; i>0; i--){
        this.snakeBoby[i][0] = this.snakeBoby[i-1][0];
        this.snakeBoby[i][1] = this.snakeBoby[i-1][1];
    }
    switch (this.direct){
        case 'right':
            this.snakeBoby[0][0] += 1;
            break;
        case 'up':
            this.snakeBoby[0][1] -= 1;
            break;
        case 'left':
            this.snakeBoby[0][0] -= 1;
            break;
        case 'down':
            this.snakeBoby[0][1] += 1;
            break;
        default:
            break;
    }
    removeClass("snake");
    snake();

    //蛇吃到食物事件
    if(this.snakeBoby[0][0] == this.foodX && this.snakeBoby[0][1] == this.foodY){
        var snakeEndX = this.snakeBoby[this.snakeBoby.length - 1][0];
        var snakeEndY = this.snakeBoby[this.snakeBoby.length - 1][1];
        switch (this.direct) {
            case 'right':
                this.snakeBoby.push([snakeEndX + 1, snakeEndY, 'body']);
                break;
            case 'up':
                this.snakeBoby.push([snakeEndX, snakeEndY - 1, 'body']);
                break;
            case 'left':
                this.snakeBoby.push([snakeEndX - 1, snakeEndY, 'body']);
                break;
            case 'down':
                this.snakeBoby.push([snakeEndX, snakeEndY + 1, 'body']);
                break;
            default:
                break;
        }
        this.score += 1;
        scoreBox.innerHTML = this.score;
        removeClass("food");
        food();
    }

    //蛇撞到墙或吃到自己
    if(this.snakeBoby[0][0] < 0 || this.snakeBoby[0][0] >= this.mapW/20){
        reloadGame();
    }
    if(this.snakeBoby[0][1] <0 || this.snakeBoby[0][1] >= this.mapH/20){
        reloadGame();
    }
    var snakeHX = this.snakeBoby[0][0];
    var snakeHY = this.snakeBoby[0][1];
    for(var i = 1; i < this.snakeBoby.length; i++){
        if(snakeHX == this.snakeBoby[i][0] && snakeHY == this.snakeBoby[i][1]){
            reloadGame();
        }
    }
}

function reloadGame() {
    removeClass("snake");
    removeClass("food");
    clearInterval(snakeMove);
    this.snakeBoby = [[3,1,'head'],[2,1,'body'],[1,1,'body']];
    this.direct = 'right';
    lose.style.display = "block";
    loserScore.innerHTML = this.score;
    this.score = 0;
    scoreBox.innerHTML = this.score;
    startGameBoolean = true;
    startPaushBoolean = true;
    startP.setAttribute("src","./img/start.png");
}

function removeClass(className) {
    var ele = document.getElementsByClassName(className);
    while(ele.length > 0){
        ele[0].parentNode.removeChild(ele[0]);
    }
}

function bindEvent() {

    close.onclick = function () {
        lose.style.display = "none";
    }

    startBtn.onclick = function () {
        startAndPaush(); //开始和停止游戏
    }
    startP.onclick = function () {
        startAndPaush();
    }
}

function setDirect(code) {
    switch (code){
        case 37:
            if(this.direct == 'up' || this.direct == 'down'){
                this.direct = 'left';
                // this.left = false;
                // this.right = false;
                // this.up = true;
                // this.down = true;
            }
            break;
        case 38:
            if(this.direct == 'left' || this.direct == 'right'){
                this.direct = 'up';
                // this.left = true;
                // this.right = true;
                // this.up = false;
                // this.down = false;
            }
            break;
        case 39:
            if(this.direct == 'up' || this.direct == 'down'){
                this.direct = 'right';
                // this.left = false;
                // this.right = false;
                // this.up = true;
                // this.down = true;
            }
            break;
        case 40:
            if(this.direct == 'left' || this.direct == 'right'){
                this.direct = 'down';
                // this.left = true;
                // this.right = true;
                // this.up = false;
                // this.down = false;
            }
            break;
        default:
            break;
    }
}

function startAndPaush() {
    if(startPaushBoolean){
        if(startGameBoolean){
            startGame();
            startGameBoolean = false;
        }
        startP.setAttribute("src","./img/stop.png");
        document.onkeydown = function (e) {
            var code = e.keyCode;
            setDirect(code);
        }
        snakeMove = setInterval('action()',speed);
        startPaushBoolean = false;
    }else {
        startP.setAttribute("src","img/start.png");
        clearInterval(snakeMove);
        document.onclick = function (e) {
            e.returnValue = false;
            return false;
        };
        startPaushBoolean = true;
    }
}

init();