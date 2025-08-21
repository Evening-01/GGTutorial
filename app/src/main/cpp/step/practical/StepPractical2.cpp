#include <jni.h>
#include <memory>

namespace StepPractical2 {
    std::unique_ptr<float> pos;
    std::unique_ptr<int> posEn;

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_practical_StepPractical2_dataLoad(
            JNIEnv *env, jobject thiz, jboolean is_created
    ) {
        if (is_created) {
            pos = std::make_unique<float>(0);
            posEn = std::make_unique<int>(0);
        } else {
            pos.reset();
            posEn.reset();
        }
    }

    extern "C"
    JNIEXPORT jfloat JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_practical_StepPractical2_pos(
            JNIEnv *env, jobject thiz
    ) {
        return *pos / 10;
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_practical_StepPractical2_left(
            JNIEnv *env, jobject thiz
    ) {
        (*pos) -= 10;
        (*posEn) += 10;
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_practical_StepPractical2_right(
            JNIEnv *env, jobject thiz
    ) {
        (*pos) += 10;
        (*posEn) -= 10;
    }

    extern "C"
    JNIEXPORT jboolean JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_practical_StepPractical2_success(
            JNIEnv *env, jobject thiz
    ) {
        return *pos / 10 == 8888.0f && int(*pos) == -*posEn;
    }
}