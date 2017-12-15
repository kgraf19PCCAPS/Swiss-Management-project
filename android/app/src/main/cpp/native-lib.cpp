#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_saltywalty_swissmanagement_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "test";
    return env->NewStringUTF(hello.c_str());
}
