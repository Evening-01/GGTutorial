#include <jni.h>
#include <memory>

namespace StepBasic3 {
    std::unique_ptr<int> hp;

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic3_dataLoad(
            JNIEnv *env, jobject thiz, jboolean is_created
    ) {
        if (is_created) {
            hp = std::make_unique<int>(328);
        } else {
            hp.reset();
        }
    }

    extern "C"
    JNIEXPORT jint JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic3_hp(
            JNIEnv *env, jobject thiz
    ) {
        return *hp;
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic3_attack(
            JNIEnv *env, jobject thiz
    ) {
        *hp -= 4;
    }

    extern "C"
    JNIEXPORT jboolean JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic3_success(
            JNIEnv *env, jobject thiz
    ) {
        return *hp == 500;
    }
}