#include <jni.h>
#include <memory>

namespace StepAgg7 {
    std::unique_ptr<int> bullet;

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_agg_StepAgg7_dataLoad(
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
    Java_me_hd_ggtutorial_ui_fragment_step_agg_StepAgg7_bullet(
            JNIEnv *env, jobject thiz
    ) {
        return *bullet;
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_agg_StepAgg7_shoot(
            JNIEnv *env, jobject thiz
    ) {
        *bullet -= 1;
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_agg_StepAgg7_replenish(
            JNIEnv *env, jobject thiz
    ) {
        *bullet += 1;
    }

    extern "C"
    JNIEXPORT jboolean JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_agg_StepAgg7_success(
            JNIEnv *env, jobject thiz
    ) {
        int bulletTmp = *bullet;
        Java_me_hd_ggtutorial_ui_fragment_step_agg_StepAgg7_shoot(env, thiz);
        bool status = *bullet == bulletTmp;
        *bullet = bulletTmp;
        return status;
    }
}