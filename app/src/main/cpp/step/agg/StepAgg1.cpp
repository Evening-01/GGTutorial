#include <jni.h>
#include <memory>

namespace StepAgg1 {
    std::unique_ptr<int> bullet;

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_agg_StepAgg1_dataLoad(
            JNIEnv *env, jobject thiz, jboolean is_created
    ) {
        if (is_created) {
            bullet = std::make_unique<int>(100);
        } else {
            bullet.reset();
        }
    }

    extern "C"
    JNIEXPORT jint JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_agg_StepAgg1_bullet(
            JNIEnv *env, jobject thiz
    ) {
        return *bullet;
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_agg_StepAgg1_shoot(
            JNIEnv *env, jobject thiz
    ) {
        *bullet -= 1;
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_agg_StepAgg1_replenish(
            JNIEnv *env, jobject thiz
    ) {
        *bullet += 1;
    }

    extern "C"
    JNIEXPORT jboolean JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_agg_StepAgg1_success(
            JNIEnv *env, jobject thiz
    ) {
        return *bullet == 999;
    }
}