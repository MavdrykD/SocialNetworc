<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1>Тут будуть відображатись всі фото</h1>

<div class="gallery">
    <img src="https://31.media.tumblr.com/tumblr_loumsfBCuE1qeo682o1_500.jpg">
    <img src="https://24.media.tumblr.com/tumblr_m1yru9PNMV1qeo682o1_500.jpg">
    <img src="https://24.media.tumblr.com/tumblr_m24ic6kY6Q1qeo682o1_500.jpg">
    <img src="https://31.media.tumblr.com/tumblr_lriz0lDN2y1qeo682o1_500.jpg">
    <img src="https://24.media.tumblr.com/tumblr_lrmgjaL62O1qeo682o1_500.jpg">
    <img src="https://24.media.tumblr.com/tumblr_lqtwuiEf8j1qeo682o1_r1_500.jpg">
    <img src="https://31.media.tumblr.com/tumblr_lqsdws3ihB1qeo682o1_500.jpg">
    <img src="https://31.media.tumblr.com/tumblr_lqscbwxUt51qeo682o1_500.jpg">
    <img src="https://31.media.tumblr.com/tumblr_lq6hl0PhyN1qeo682o1_500.jpg">
    <img src="https://24.media.tumblr.com/tumblr_lo6iddvEi51qeo682o1_500.jpg">
</div>

<a href="/addPhotos" class="btn btn-warning"><spring:message code="label.AddMorePhotos"/></a>


<script>
    function scaleGallery()
    {
        // This is roughly the max pixels width/height of a square photo
        var widthSetting = 400;

        // Do not edit any of this unless you know what you're doing
        var containerWidth = $(".gallery").width();
        var ratioSumMax = containerWidth / widthSetting;
        var imgs = $(".gallery img");
        var numPhotos = imgs.length, ratioSum, ratio, photo, row, rowPadding, i = 0;

        while (i < numPhotos) {
            ratioSum = rowPadding = 0;
            row = new Array();
            while (i < numPhotos && ratioSum < ratioSumMax) {
                photo = $(imgs[i]);
                // reset width to original
                photo.width("");
                ratio = photo.width() / photo.height();
                rowPadding += getHorizontalPadding(photo);
                // if this is going to be first in the row, clear: left
                if(ratioSum == 0) photo.css("clear", "left"); else photo.css("clear", "none");
                ratioSum += ratio;
                row.push(photo);
                i++;
                // if only 1 image left, squeeze it in
                if(i == numPhotos - 1) ratioSumMax = 999;
            }
            unitWidth = (containerWidth - rowPadding) / ratioSum;

            row.forEach(function (elem) {
                elem.width(unitWidth * elem.width() / elem.height());
            });
        }
    }

    function getHorizontalPadding(elem)
    {
        var padding = 0;
        var left = elem.css("padding-left");
        var right = elem.css("padding-right");
        padding += parseInt(left ? left.replace("px", "") : 0);
        padding += parseInt(right ? right.replace("px", "") : 0);
        return padding;
    }

    $(window).load(scaleGallery);
    $(window).resize(scaleGallery);
</script>