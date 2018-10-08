/**
 *
 * 定义颜色
 * */
var color = ["#7bcb0a","#f75352","#099eb2","#318df0","#852cc2","#cc6ec2","#e5b03c","#319152"];

/**
 * @date 2017-07-24
 * @description 随机生成颜色色块
 */
function getRandomNum(min,max) {
    return min + Math.round(Math.random() * (max - min));
}
var alreadyColorArray = new Array();
function getRandColor() {
    var randColor = "";
    do {
        randColor = color[getRandomNum(0,color.length-1)];
    } while(!validateRepeatColor(randColor));
    alreadyColorArray.push(randColor); // 已经生成的颜色加入到数组，需要遍历取不同的颜色判断的时候用
    return randColor;
}

/**
 * @date 2017-07-24
 * @description 判断当前的颜色是否和前两个颜色一样，一样返回false，不一样返回true
 */
function validateRepeatColor(currentColor) {
    var currentIndex = alreadyColorArray.length;
    if (currentIndex > 1) {
        if (alreadyColorArray[currentIndex - 2] != currentColor &&
            alreadyColorArray[currentIndex - 1] != currentColor) {
            return true;
        } else {
            return false;
        }
    } else if (currentIndex > 0) {
        if (alreadyColorArray[currentIndex - 1] != currentColor) {
            return true;
        } else {
            return false;
        }
    }
    return true;
}
