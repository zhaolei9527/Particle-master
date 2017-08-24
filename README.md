# Particle-master
小米手机用户可以看到，小米手机在应用卸载时会有一个粒子爆炸的特效效果，对此类动画效果垂涎已久，奈何一直没有机会用。正好最近项目里需要用到粒子爆炸的特效，于是便抽时间自己也试着仿写了一个效果出来。

**先看下效果：**

![粒子特效](https://github.com/zhaolei9527/Particle-master/blob/master/sample/src/main/res/mipmap-xhdpi/sample.gif)

## 相关内容参数详细介绍《简书》：[Android粒子爆炸特效[可用于任意控件]](http://www.jianshu.com/p/39a27bba44da)


 ****
# How to use：

[![](https://jitpack.io/v/zhaolei9527/Particle-master.svg)](https://jitpack.io/#zhaolei9527/Particle-master)
[![](https://img.shields.io/badge/Go%20to-%E7%AE%80%E4%B9%A6-brightgreen.svg)](http://www.jianshu.com/p/39a27bba44da)

**Step 1. Add the JitPack repository to your build file**
**Add it in your root build.gradle at the end of repositories:**
```java
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2.Add the dependency**
```java
	dependencies {
	        compile 'com.github.zhaolei9527:Particle-master:v1.0.1'
	}
```
**代码中这样使用：**

首先提供了响应式触发的方式，首先进行埋雷，当控件被点击时，触发爆炸。是不是很刺激？
```java 
   //目前提供了六种的粒子爆炸特效
        explosionSite1 = new ExplosionSite(this, new BooleanFactory());
        explosionSite2 = new ExplosionSite(this, new ExplodeParticleFactory());
        explosionSite3 = new ExplosionSite(this, new FallingParticleFactory());
        explosionSite4 = new ExplosionSite(this, new FlyawayFactory());
        explosionSite5 = new ExplosionSite(this, new InnerFallingParticleFactory());
        explosionSite6 = new ExplosionSite(this, new VerticalAscentFactory());

        //爆炸激活方式一：将View或ViewGroup添加至雷管监听，View被点击时，触发爆炸
        explosionSite1.addListener(img_1);
        explosionSite2.addListener(img_2);
        explosionSite3.addListener(img_6);
        explosionSite4.addListener(img_4);
        explosionSite5.addListener(img_5);
        explosionSite6.addListener(img_3);
```
其次针对一些情况，提供了另外一种直接的触发方式。是不是更刺激？
```java
                //爆炸激活方式二：将View或ViewGroup直接点燃爆炸
                explosionSite1.explode(img_1);
                explosionSite2.explode(img_2);
                explosionSite3.explode(img_3);
                explosionSite4.explode(img_4);
                explosionSite5.explode(img_5);
                explosionSite6.explode(img_6);
```

网上实现类似相同效果的很多，基本规则也都差不多。
主要对象如下：
**ExplosionSite**：爆炸效果发生的场地，是一个View。当一个控件需要爆炸时，需要为控件生成一个ExplosionSite，这个ExplosionSite覆盖整个屏幕，于是我们才能看到完整的爆炸效果，在ExplosionField的构造函数中，传入不同的ParticleFactory，就可以生成不同的爆炸效果。 

**ExplosionAnimator**：爆炸动画，其实是一个计时器，继承自ValueAnimator。0x400s内，完成爆炸动画，每次计时，就更新所有粒子的运动状态。draw()方法是它最重要的方法，也就是使所有粒子重绘自身，从而实现动画效果。

**ParticleFactory**：是一个抽象类。用于产生粒子数组，不同的ParticleFactory可以产生不同类型的粒子数组。

**Particle**：抽象的粒子类。代表粒子本身，必须拥有的属性包括，当前自己的cx,cy坐标和颜色color。必须实现两个方法，draw()方法选择怎么绘制自身(圆形还是方形等),caculate()计算当前时间，自己所处的位置。 
****

**有了需求才有了功能，有了想法才有了创作，你的反馈会是使我进步的最大动力。**
**觉得还不够方便？还想要什么功能？告诉我！欢迎反馈，欢迎Star。**
