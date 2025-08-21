#include <jni.h>
#include <memory>
#include <array>

namespace StepBasic2 {
    struct Player {
        std::unique_ptr<int> hp;
        std::unique_ptr<int> mp;
    } player;

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic2_dataLoad(
            JNIEnv *env, jobject thiz, jboolean is_created
    ) {
        if (is_created) {
            player.hp = std::make_unique<int>(100);
            player.mp = std::make_unique<int>(150);
        } else {
            player.hp.reset();
            player.mp.reset();
        }
    }

    extern "C"
    JNIEXPORT jintArray JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic2_hpMpArray(
            JNIEnv *env, jobject thiz
    ) {
        std::array<jint, 2> stdArray = {*player.hp, *player.mp};
        jintArray intArray = env->NewIntArray(stdArray.size());
        env->SetIntArrayRegion(intArray, 0, stdArray.size(), stdArray.data());
        return intArray;
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic2_skill(
            JNIEnv *env, jobject thiz
    ) {
        (*player.mp) -= 6;
    }

    extern "C"
    JNIEXPORT jboolean JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic2_success(
            JNIEnv *env, jobject thiz
    ) {
        return *player.hp == 999 && *player.mp == 999;
    }
}