// recording that visits all channels
// Run with Instruments Automation and paste in there.
// Note that this just records location of taps
var target = UIATarget.localTarget();

target.frontMostApp().navigationBar().buttons()["show menu"].tap();
target.frontMostApp().mainWindow().tableViews()[1].tapWithOptions({tapOffset:{x:0.16, y:0.30}});
target.frontMostApp().navigationBar().buttons()["show menu"].tap();
target.frontMostApp().mainWindow().tableViews()[1].tapWithOptions({tapOffset:{x:0.37, y:0.29}});
target.frontMostApp().navigationBar().buttons()["show menu"].tap();
target.frontMostApp().mainWindow().tableViews()[1].tapWithOptions({tapOffset:{x:0.58, y:0.29}});
target.frontMostApp().navigationBar().buttons()["show menu"].tap();
target.frontMostApp().mainWindow().tableViews()[1].tapWithOptions({tapOffset:{x:0.17, y:0.39}});
target.frontMostApp().navigationBar().buttons()["show menu"].tap();
target.frontMostApp().mainWindow().tableViews()[1].tapWithOptions({tapOffset:{x:0.38, y:0.40}});
target.frontMostApp().navigationBar().buttons()["show menu"].tap();
target.frontMostApp().mainWindow().tableViews()[1].tapWithOptions({tapOffset:{x:0.59, y:0.40}});
target.frontMostApp().navigationBar().buttons()["show menu"].tap();
target.frontMostApp().mainWindow().tableViews()[1].tapWithOptions({tapOffset:{x:0.23, y:0.58}});
target.frontMostApp().navigationBar().buttons()["show menu"].tap();
target.frontMostApp().mainWindow().tableViews()[1].tapWithOptions({tapOffset:{x:0.24, y:0.74}});
target.frontMostApp().mainWindow().buttons()["Recently Viewed"].tap();
target.frontMostApp().navigationBar().buttons()["show menu"].tap();
target.frontMostApp().mainWindow().tableViews()[1].cells()["Home button"].tap();
target.frontMostApp().navigationBar().buttons()["Search"].tap();
target.frontMostApp().keyboard().typeString("Who");
target.frontMostApp().mainWindow().tableViews()[0].cells()["ABC Mental As... 5-12 October"].tap();
target.frontMostApp().navigationBar().buttons()["show menu"].tap();
target.frontMostApp().mainWindow().tableViews()[1].cells()["Home button"].tap();
