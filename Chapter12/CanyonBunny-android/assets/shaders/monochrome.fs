#ifdef GL_ES
	precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_texCoords;
uniform sampler2D u_texture;
uniform float u_amount; 

void main() {
	vec4 color = v_color * texture2D(u_texture, v_texCoords);
	float grayscale = dot(color.rgb, vec3(0.222, 0.707, 0.071));
	color.rgb = mix(color.rgb, vec3(grayscale), u_amount);
	gl_FragColor = color;
}