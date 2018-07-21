var color = ["#7bcb0a","#f75352","#099eb2","#318df0","#852cc2","#cc6ec2","#e5b03c","#319152"];

/**
 * 获取随机数字
 * @param min
 * @param max
 * @returns {*}
 */
function getRandomNum(min,max) {
    return min + Math.round(Math.random() * (max - min));
}

var alreadyColorArray = new Array();

/***
 * 获取随机颜色 - 调运实例： backgroundcolor: getRandColor();
 * @returns {string}
 */
function getRandColor() {
    var randColor = "";
    do{
        randColor = color[getRandomNum(0,color.length - 1)];
    }while (!validateRepeatColor(randColor));
    alreadyColorArray.push(randColor);
    return randColor;
}

/***
 * 获取随机颜色
 * @param currentColor
 * @returns {boolean}
 */
function validateRepeatColor(currentColor) {
    var currentIndex = alreadyColorArray.length;
    if (currentIndex > 1){
        if(alreadyColorArray[currentIndex - 2] != currentColor && alreadyColorArray[currentIndex - 1] != currentColor){
            return true;
        }else{
            return false;
        }

    }else if(currentIndex > 0){
        if(alreadyColorArray[currentIndex - 1] != currentColor){
            return true;
        }else{
            return  false;
        }
    }

};

