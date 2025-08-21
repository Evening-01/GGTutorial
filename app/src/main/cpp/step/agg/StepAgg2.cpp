#include <jni.h>
#include <memory>

namespace StepAgg2 {
    std::unique_ptr<int> bullet;

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_agg_StepAgg2_dataLoad(
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
    Java_me_hd_ggtutorial_ui_fragment_step_agg_StepAgg2_bullet(
            JNIEnv *env, jobject thiz
    ) {
        return *bullet;
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_agg_StepAgg2_shoot(
            JNIEnv *env, jobject thiz
    ) {
        *bullet -= 1;
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_agg_StepAgg2_replenish(
            JNIEnv *env, jobject thiz
    ) {
        *bullet += 1;
    }

    extern "C"
    JNIEXPORT jboolean JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_agg_StepAgg2_success(
            JNIEnv *env, jobject thiz
    ) {
        int bulletAdd = *bullet;
        Java_me_hd_ggtutorial_ui_fragment_step_agg_StepAgg2_shoot(env, thiz);
        bool statusAdd = *bullet > bulletAdd;
        *bullet = bulletAdd;
        int bulletSub = *bullet;
        Java_me_hd_ggtutorial_ui_fragment_step_agg_StepAgg2_replenish(env, thiz);
        bool statusSub = *bullet < bulletSub;
        *bullet = bulletSub;
        return statusAdd || statusSub;
    }
}