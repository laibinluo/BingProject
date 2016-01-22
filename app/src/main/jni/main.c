#include "luo_bing_com_bingproject_ndk_demo_HelloNDK.h"

/*
 * Class:     luo_bing_com_bingproject_ndk_demo_HelloNDK
 * Method:    sayHello
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_luo_bing_com_bingproject_ndk_1demo_HelloNDK_sayHello
  (JNIEnv *env, jobject object){
        return (*env)->NewStringUTF(env,"This is test ndk");
}