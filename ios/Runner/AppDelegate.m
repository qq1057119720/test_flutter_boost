#import "AppDelegate.h"
#import "GeneratedPluginRegistrant.h"
#import "MyFlutterBoostDelegate.h"
#import <flutter_boost/FlutterBoost.h>
#import "UIViewControllerDemo.h"
#import "NativeViewController.h""
@implementation AppDelegate

- (BOOL)application:(UIApplication *)application
    didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    
   
  [GeneratedPluginRegistrant registerWithRegistry:self];
    self.window = [[UIWindow alloc] initWithFrame: [UIScreen mainScreen].bounds];
    
    
    [self.window makeKeyAndVisible];
    
    //默认方法
    MyFlutterBoostDelegate* delegate=[[MyFlutterBoostDelegate alloc ] init];
    [[FlutterBoost instance] setup:application delegate:delegate callback:^(FlutterEngine *engine) {

    } ];

    //下面是自定义option参数的方法
    
//    FlutterBoostSetupOptions* options = [FlutterBoostSetupOptions createDefault];
//    options.dartEntryPoint = @"main2";
//
//    [[FlutterBoost instance] setup:application delegate:delegate callback:^(FlutterEngine *engine) {
//    } options:options];
    
    UIViewControllerDemo *vc = [[UIViewControllerDemo alloc] initWithNibName:@"UIViewControllerDemo" bundle:[NSBundle mainBundle]];
    vc.tabBarItem = [[UITabBarItem alloc] initWithTitle:@"hybrid" image:nil tag:0];
   
    FBFlutterViewContainer *fvc = FBFlutterViewContainer.new ;

    [fvc setName:@"tab_friend" uniqueId:nil params:@{} opaque:YES];
    fvc.tabBarItem = [[UITabBarItem alloc] initWithTitle:@"flutter_tab" image:nil tag:1];


    UITabBarController *tabVC = [[UITabBarController alloc] init];
    tabVC.viewControllers = @[vc,fvc];

    
    UINavigationController *rvc = [[UINavigationController alloc] initWithRootViewController:tabVC];
    
    delegate.navigationController=rvc;

    self.window.rootViewController = rvc;
    
    FlutterBoostRouteOptions* options = [[FlutterBoostRouteOptions alloc]init];
    options.pageName = @"splash";
    options.arguments = @{@"animated":@(YES)};
    options.completion = ^(BOOL completion) {
        
    };
    
    [[FlutterBoost instance]open:options];
    
    return YES;
}
@end
