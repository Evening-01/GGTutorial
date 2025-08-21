#include <jni.h>
#include <memory>

namespace StepBasic4 {
    std::unique_ptr<int> num;

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic4_dataLoad(
            JNIEnv *env, jobject thiz, jboolean is_created
    ) {
        if (is_created) {
            num = std::make_unique<int>(100);
        } else {
            num.reset();
        }
    }

    extern "C"
    JNIEXPORT jint JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic4_show(
            JNIEnv *env, jobject thiz
    ) {
        return *num / 2;
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic4_add(
            JNIEnv *env, jobject thiz
    ) {
        (*num) += 20;
    }

    extern "C"
    JNIEXPORT jboolean JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic4_success(
            JNIEnv *env, jobject thiz
    ) {
        return *num == 8888;
    }
}